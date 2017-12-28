package com.ctci.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ayanc on 7/23/17.
 */
public class Problem2 {
  class Point{
    int rowIndex;

    public int getColIndex() {
      return colIndex;
    }

    public void setColIndex(int colIndex) {
      this.colIndex = colIndex;
    }

    int colIndex;

    public int getRowIndex() {
      return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
      this.rowIndex = rowIndex;
    }

    public Point(int rowIndex, int colIndex) {
      this.rowIndex = rowIndex;
      this.colIndex = colIndex;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Point point = (Point) o;

      if (rowIndex != point.rowIndex) return false;
      return colIndex == point.colIndex;

    }

    @Override
    public int hashCode() {
      int result = rowIndex;
      result = 31 * result + colIndex;
      return result;
    }
  }

  public List<Point> getPath(boolean[][] maze){
    if(maze == null || maze.length == 0) return null;
    List<Point> path = new ArrayList<>();
    if(getPath(maze, new Point(maze.length - 1, maze[0].length - 1), new HashSet<Point>(), path)){
      return path;
    }
    return null;
  }

  private boolean getPath(boolean[][] maze, Point toPoint, Set<Point> failedPoints, List<Point> path){
    if(toPoint.getRowIndex() < 0 || toPoint.getColIndex() < 0 || !maze[toPoint.getRowIndex()][toPoint.getColIndex()])
      return false;
    if(failedPoints.contains(toPoint)) return false;
    if((toPoint.getRowIndex() == 0 & toPoint.getColIndex() == 0) || getPath(maze, new Point(toPoint.getRowIndex() - 1,
        toPoint.getColIndex()), failedPoints, path) || getPath(maze, new Point(toPoint.getRowIndex(),
        toPoint.getColIndex() - 1), failedPoints, path)){
      path.add(toPoint);
      return true;
    }
    failedPoints.add(toPoint);
    return false;

  }
}
