/*  Student information for assignment:
 *
 *  On my honor, Wenjing Xie, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: wx674
 *  email address: wenjing.xie@utexas.edu
 *  Grader name: Eric
 *  Number of slip days I am using: 0
 */

/*
 * Question. The assignment presents three ways to rank teams using graphs.
 * The results, especially for the last two methods are reasonable. 
 * However if all results from all college football teams are included 
 * some unexpected results occur. 
 * 
 * Suggest another way of method of ranking teams using the results 
 * from the graph. Thoroughly explain your method. The method can build 
 * on one of the three existing algorithms.
 * 
 * when I try to read the games08.txt file by changing the String variable gameResults to 
 * this txt file, I always get error when build the graph. 
 * 
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
	at FootballRanker.buildGraph(FootballRanker.java:299)
	at FootballRanker.<init>(FootballRanker.java:87)
	at GraphAndRankTester.main(GraphAndRankTester.java:36)
	
	Thus, I have no idea about the "surprise" when using the records which all teams are included.
 * 
 * 
 */

public class GraphAndRankTester {
    
    public static void main(String[] args)  {
        testGraph();
        
        String actual = "2005ap_poll.txt";
        String gameResults = "div12005.txt";
        
        FootballRanker ranker = new FootballRanker(gameResults, actual);
        ranker.doUnweighted(true);
        ranker.doWeighted(true);
        ranker.doWeightedAndWinPercentAdjusted(true);
        // TODO
        //ranker.doWeightedWinPercentAdjustedAndOpponents(true);
        
        System.out.println();
        doRankTests(ranker);
        
        System.out.println();
        //testGraph();
    }
    
    public static void doRankTests(FootballRanker ranker) {
        double actualError = ranker.doUnweighted(false);
        if(actualError == 6.8)
            System.out.println("Passed unweighted test");
        else
            System.out.println("FAILED UNWEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected 13.7, actual: " + actualError);
        
        actualError = ranker.doWeighted(false);
        if(actualError == 5.8)
            System.out.println("Passed weigthed test");
        else
            System.out.println("FAILED WEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected 12.6, actual: " + actualError);
        
        
        actualError = ranker.doWeightedAndWinPercentAdjusted(false);
        if(actualError == 3.0)
            System.out.println("Passed unweighted win percent test");
        else
            System.out.println("FAILED WEIGHTED  AND WIN PERCENT ROOT MEAN SQUARE ERROR TEST. Expected 6.3, actual: " + actualError);       
    }
    
    public static void testGraph() {
        String [][] edges = 
               {{"E", "H", "2"},
        		{"A", "B", "1"},
                {"B", "C", "3"},
                {"B", "D", "21"},
                {"C", "F", "3"},
                {"A", "G", "17"},
                {"D", "F", "4"},
                {"D", "G", "5"},
                {"D", "E", "6"},
                {"A", "C", "7"}};
        
        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
            g.addEdge(edge[1], edge[0], Integer.parseInt(edge[2]));
        }

        g.dijkstra("A");
        
        String actualPath = g.findPath("H").toString();
        String expected = "[A, B, C, F, D, E, H]";
        if(actualPath.equals(expected))
            System.out.println("Passed dijkstra path test.");
        else
            System.out.println("Failed dijkstra path test. Expected: " + expected + " actual " + actualPath);  
        
        // find all paths using unweighted edges
        g.findAllPaths(false);
        int actualDiameter = g.getDiameter();
        if(actualDiameter == 4)
            System.out.println("Passed diameter test with weighted == false.");
        else
            System.out.println("Failed diameter test with weighted == false. Expected 4 got " + actualDiameter);
        
        double costOfLongestShortestPath = g.costOfLongestShortestPath();
        if(costOfLongestShortestPath == 4.0)
            System.out.println("Passed cost of longest shortest path test with weighted == false.");
        else
            System.out.println("Failed cost of longest shortest path test with weighted == false. Expected 3.0 got " + actualDiameter);
        
        System.out.println();
        
        String[] expectedPaths = {  "Name: D                    cost per path: 1.4286, num paths: 7",
                                    "Name: B                    cost per path: 1.7143, num paths: 7",
                                    "Name: F                    cost per path: 1.8571, num paths: 7",
                                    "Name: G                    cost per path: 1.8571, num paths: 7",
                                    "Name: A                    cost per path: 2.0000, num paths: 7",
                                    "Name: C                    cost per path: 2.0000, num paths: 7",
                                    "Name: E                    cost per path: 2.0000, num paths: 7",
                                    "Name: H                    cost per path: 2.8571, num paths: 7"};
        
        testAllPathsInfo(g, expectedPaths);
        
        // find all paths using weighted edges
        g.findAllPaths(true);
        actualDiameter = g.getDiameter();
        if(actualDiameter == 6)
            System.out.println("Passed diameter test with weighted == true.");
        else
            System.out.println("Failed diameter test with weighted == true. Expected 6 got " + actualDiameter);
             
        costOfLongestShortestPath = g.costOfLongestShortestPath();
        if(costOfLongestShortestPath == 19.0)
            System.out.println("Passed cost of longest shortest path test with weighted = true");
        else
            System.out.println("Failed cost of longest shortest path test with weighted = true. Expected 19.0 got " + costOfLongestShortestPath );
        
        
        expectedPaths = new String[] {  "Name: D                    cost per path: 7.2857, num paths: 7",
                                        "Name: F                    cost per path: 7.2857, num paths: 7",
                                        "Name: C                    cost per path: 8.1429, num paths: 7",
                                        "Name: B                    cost per path: 9.8571, num paths: 7",
                                        "Name: A                    cost per path: 10.7143, num paths: 7",
                                        "Name: E                    cost per path: 10.7143, num paths: 7",
                                        "Name: G                    cost per path: 11.5714, num paths: 7",
                                        "Name: H                    cost per path: 12.4286, num paths: 7"};
        testAllPathsInfo(g, expectedPaths);
        
    }
    
    
    
    private static void testAllPathsInfo(Graph g, String[] expectedPaths) {
        int index = 0;
        
        for(AllPathsInfo api : g.getAllPaths()) {
            if(expectedPaths[index].equals(api.toString())) {
                System.out.println(expectedPaths[index] + " is correct!!");
            }
            else {
                System.out.println("ERROR IN ALL PATHS INFO: ");
                System.out.println("index: " + index);
                System.out.println("EXPECTED: " + expectedPaths[index]);
                System.out.println("ACTUAL: " + api.toString());
                System.out.println();
            }
            index++;
        }
        System.out.println();
    }
}
