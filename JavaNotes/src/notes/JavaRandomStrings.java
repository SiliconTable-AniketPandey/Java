package notes;


public class JavaRandomStrings {
    public static void main(String[] args) {
        String[] wordListOne = {"agnostic", "opinionated",
                                "voice activated", "haptically driven", "extensible",
                                "reactive", "agent based", "functional", "AI enabled",
                                "strongly typed"};

        String[] wordListTwo = {"loosely coupled", "six sigma",
                                "asynchronous", "event driven", "pub-sub", "IoT", "cloudnative", "service oriented", "containerized", "serverless",
                                "microservices", "distributed ledger"};

        String[] wordListThree = {"framework", "library",
                                "DSL", "REST API", "repository", "pipeline", "servicemesh", "architecture", "perspective", "design",
                                "orientation"};
        
        // Find out how many words are in each list
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;


        // generate random number
        java.util.Random randomGenerator = new java.util.Random();
        int rand1 = randomGenerator.nextInt(oneLength); // (0,n-1)
        int rand2 = randomGenerator.nextInt(twoLength);  // (0, n-1)
        int rand3 = randomGenerator.nextInt(threeLength); // (0,n-1)

        // build a phrase
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        // print out the phrase
        System.out.println("What we need is "+phrase);
    }
}
