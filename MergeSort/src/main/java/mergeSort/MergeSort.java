package mergeSort;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MergeSort {
  /**
   * Thread that declares the lambda and then initiates the work
   */

  public static int message_id = 0;

  public static JSONObject init(int[] array) {
    JSONArray arr = new JSONArray();
    for (var i : array) {
      arr.put(i);
    }
    JSONObject req = new JSONObject();
    req.put("method", "init");
    req.put("data", arr);
    return req;
  }

  public static JSONObject peek() {
    JSONObject req = new JSONObject();
    req.put("method", "peek");
    return req;
  }

  public static JSONObject remove() {
    JSONObject req = new JSONObject();
    req.put("method", "remove");
    return req;
  }
  
  public static void Test(int port, String host) {

    //int[] a = { 5, 1, 6, 2, 3, 4, 10,634,34,23,653, 23,2 ,6};
    //int[] a = { 100, 200, 6400, 212, 33, 4123, 102132312,623234,2334,212313,6553, 2653,256 ,6566, 45,787, 56345, 54756,3453452,345,657,1,2,3,4,7,567,7,7,7};
    int[] a = { 100, 200, 6400, 212, 33, 4123, 102132312,623234,2334,212313,6553, 2653,256 ,6566, 45,787, 56345, 54756,3453452,345,657,1,2,3,4,7,567,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,1,23,4,3,4,5,6,4,5,74,8,2,3,4,2745,9,86,7,7,2,3,4,2,4,67,4,5,6,323,4,567897,6,54345,6,765,46,787,64,753,25679529, 1,1,1,1,1,1,1,1,1,1,0,0,0,-1};
    JSONObject response = NetworkUtils.send(host, port, init(a));
    
    System.out.println(response);
    response = NetworkUtils.send(host, port, peek());
    System.out.println(response);

    while (true) {
      response = NetworkUtils.send(host, port, remove());

      if (response.getBoolean("hasValue")) {
        System.out.println(response);;
 
      } else{
        break;
      }
    }
  }

  public static void main(String[] args) {
    //include finding the time it takes
    long startTime = System.nanoTime();

    // use the port of one of the branches to test things
    Test(Integer.valueOf(args[0]), args[1]);

    //calculate and print out time it took
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    double timeInSeocnds = totalTime / 1000000000.00000;
    System.out.println("Total Time: " +totalTime + " ns");
    System.out.println("Total Time: " +timeInSeocnds + " s");
  }
}
