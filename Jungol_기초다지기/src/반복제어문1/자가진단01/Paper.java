package 반복제어문1.자가진단01;

 class Paper {
	 public int b;
	 		protected Paper(int b) { this.b = b; }
	 		protected Paper() {}
	 		
	 		
	  }
	  class Box extends Paper {
	  		public Box(int b) { super(b); }
	  		public Box() { b = 5; }
	  		
	  }


