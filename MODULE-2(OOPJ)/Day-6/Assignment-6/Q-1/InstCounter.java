package assign.pending;

public class InstCounter {

	    private static int instanceCount = 0;
	    public InstCounter() {
	        instanceCount++;
	    }
	    public static int getInstanceCount() {
	        return instanceCount;
	    }
	    public String toString() {
	        return "InstanceCounter with " + instanceCount + " instances.";
	    }
	    public static void main(String[] args) {
	        InstCounter obj1 = new InstCounter();
	        InstCounter obj2 = new InstCounter();
	        System.out.println("Number of instances created: " + InstCounter.getInstanceCount());
	        System.out.println(obj1.toString());
	    }
	}



