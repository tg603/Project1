import java.util.ArrayList;

public class squirtle{


		public static boolean test1(){
			ArrayList wet = new ArrayList();
			wet.add("T");
			String splash = "T";
				if (wet.contains("T")){
					System.out.println(wet.toString() + " contains " + splash);
					return true;
				}
				else{
					System.out.println("False");
					return false;
				}
		}
		
		public static boolean test2(){
				ArrayList moist = new ArrayList();
				moist.add(2);
				int num = 2;
				if(moist.contains(2)){
					System.out.println(moist.toString() + " contains " + num);
					return true;
				}
				else{
					System.out.println("False");
					return false;
				}
		}
		
				
		public static boolean test3(){
				ArrayList moist = new ArrayList();
				moist.add(4);
				int num = 2;
				if(moist.contains(num)){
					System.out.println("True");
					return true;
				}
				else{
					System.out.println(moist.toString() + " does not contain " + num);
					return false;
				}
		}
		
				public static boolean test4(){
				ArrayList wet = new ArrayList();
				wet.add("hi");
				String splash = "hello";
				if(wet.contains(splash)){
					System.out.println("True");
					return true;
				}
				else{
					System.out.println(wet.toString() + " does not contain " + splash);

					return false;
				}
		}
		
		
		public static void test5(){
			ArrayList wet = new ArrayList();
			wet.add(1);
			wet.add(2);
			wet.add(3);
			System.out.println("Wet elements: " + wet);
			System.out.println("Index 0 contains " + wet.get(0));
			System.out.println("Index 2 contains " + wet.get(2));
		}
		
		public static void test6(){
			ArrayList wet = new ArrayList();
			wet.add(1);
			wet.add(0);
			wet.add(3);
			wet.add(4);
			wet.add(7);
			wet.add(3);
			wet.add(0);
			System.out.println("List of wet elements: " + wet + " the first instance of element three is in index " + wet.indexOf(3));
			System.out.println("List of wet elements: " + wet + " the first instance of element zero is in index " + wet.indexOf(0));
		}
		public static boolean test7(){
			ArrayList wet = new ArrayList();
			wet.clear();
			if (wet.isEmpty()){
				System.out.println("No elements found");
				return true;
			}
			else{
				return false;
			}
		}
				public static boolean test8(){
			ArrayList wet = new ArrayList();
			wet.add(1);
			if (wet.isEmpty()){
				System.out.println("No elements found");
				return true;
			}
			else{
				System.out.println("Elements in List");
				return false;
			}
		}
		
		public static void test9(){
			ArrayList wet = new ArrayList();
			wet.add(1);
			wet.add(2);
			wet.add(3);
			System.out.println(wet);
			wet.remove(1);
			System.out.println(wet);
		}
		
		public static boolean test10(){
			ArrayList wet = new ArrayList();
			wet.add(3);
			wet.add(2);
			wet.add(3);
			System.out.println("Wet elements before removal of 3" + wet);
			if(wet.contains(3)){
				wet.remove((Object)3);
				System.out.println("Wet elements after removal of 3" + wet);
				return true;
			}else{
			System.out.println(wet);
			return false;
			}
		}
		
		public static void test11(){
			ArrayList wet = new ArrayList();
			wet.add(1);
			wet.add(2);
			wet.add(3);
			System.out.println(wet);
			wet.set(0,6);
			System.out.println(wet);
			System.out.println("There are " + wet.size() + " elements in Wet.");
		}
		
	public static void main (String Args []){
	ArrayList turtle = new ArrayList();
	turtle.add (1);
	ArrayList shell = new ArrayList();
	shell.add ("hi");
	shell.add("Not enough PP for this attack!");
	System.out.println("Shell arrayList: " + shell + " Turtle arrayList: " + turtle);
	
	shell.clear();
	turtle.clear();
	System.out.println("Shell arrayList: " + shell + " Turtle arrayList: " + turtle);
		/*
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
		*/
		
		int maxBoardSize = 10;
		double pachydermDensity = .4; //percentage each space will hold a pachydermDensity
		PositionFactory<ElephantsAndRhinos> factory = new ElephantsAndRhinos.PositionBuilder(maxBoardSize, pachydermDensity);
		Player<ElephantsAndRhinos> random = new RandomPlayer<ElephantsAndRhinos>();
		Player<ElephantsAndRhinos> user = new ElephantsAndRhinosPlayer();
		Referee<ElephantsAndRhinos> ref = new Referee<ElephantsAndRhinos>(random, user, factory);
		ref.call();
		ref.gauntlet(1000);
	}
	
}