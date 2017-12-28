package com.rtp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 * Created by ayanc on 7/10/17.
 */
public class SolrCaller {
  private static final String RTP_SOLR_URL = "http://solrcloud-all1-searchteam-dev.dev.rtp-trulia.com:8983/solr/for-sale-primary-read";
  private static final String ADHOC_SOLR_URL = "http://adhoc-index.sv2.trulia.com:8050/active";
  private static final String QUERY = "truliaBuilderCommunityId_s:*";
  private static final String FIELDS = "truliaBuilderCommunityId_s";
  private static final int PAGE_SIZE = 10000;


  protected static Function<List<SolrDocument>, Set<String>> RETRIEVE_TRULIA_COMMUNITY_ID = solrDocuments -> solrDocuments
      .stream().map(solrDocument -> (String)solrDocument.getFieldValue("truliaBuilderCommunityId_s"))
      .collect(Collectors.toSet());


  public static void main(String[] args) throws IOException, SolrServerException {
    SolrCaller solrCaller = new SolrCaller();
    SolrClient client = new HttpSolrClient.Builder(RTP_SOLR_URL).build();
    List<SolrDocument> documents = solrCaller.findAllDocuments(client, QUERY, FIELDS);
    Set<String> rtpSet = RETRIEVE_TRULIA_COMMUNITY_ID.apply(documents);
    System.out.println("rtp: " + rtpSet.size());
    client = new HttpSolrClient.Builder(ADHOC_SOLR_URL).build();
    documents = solrCaller.findAllDocuments(client, QUERY, FIELDS);
    Set<String> adHocSet = RETRIEVE_TRULIA_COMMUNITY_ID.apply(documents);
    System.out.println("adhoc: " + adHocSet.size());
    adHocSet.removeAll(rtpSet);
    System.out.println("diff: " + adHocSet);
//    rtpSet.removeAll(adHocSet);
//    System.out.println("diff: " + rtpSet);
  }




  public List<SolrDocument> findAllDocuments(SolrClient solrClient, String query, String fields) throws IOException,
      SolrServerException{
    long numberOfDocuments = numberOfDocuments(solrClient, query, fields);
    int start = 0, rows = PAGE_SIZE;
    List<SolrDocument> list = new ArrayList<>();
    do {
      list.addAll(retrieveData(solrClient, start, rows, query, fields));
      start += PAGE_SIZE;
    } while (start < numberOfDocuments);
    return list;
  }

  private List<SolrDocument> retrieveData(SolrClient solrClient, Integer start, Integer rows, String query,
                                          String fields) throws IOException, SolrServerException{

    SolrQuery solrQuery = new SolrQuery();
    //query.setQuery("sony digital camera");
    solrQuery.setQuery(query);
    solrQuery.setFields(fields);
    if(start != null){
      solrQuery.setStart(start);
    }
    if(rows != null){
      solrQuery.setRows(rows);
    }

    QueryResponse response = solrClient.query(solrQuery);
    List<SolrDocument> list = new ArrayList<>();
    SolrDocumentList results = response.getResults();
    for (int i = 0; i < results.size(); ++i) {
      list.add(results.get(i));
    }
    return list;
  }

  private long numberOfDocuments(SolrClient solrClient, String query,
                                          String fields) throws IOException, SolrServerException{
    SolrQuery solrQuery = new SolrQuery();
    solrQuery.setQuery(query);
    solrQuery.setFields(fields);
    QueryResponse response = solrClient.query(solrQuery);
    SolrDocumentList results = response.getResults();
    return results.getNumFound();
  }



}
