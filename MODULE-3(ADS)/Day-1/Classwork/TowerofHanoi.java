class TowerofHanoi{
	static void hanoiCalc(int num,char source ,char destination,char temp){
		if(num==1){
			System.out.println("Move Disk "+num+ " from  "+source+" to "+destination);
		}
		else{
			hanoiCalc(num-1,source,temp,destination);
			System.out.println("Move Disk "+num+ " from  "+source+" to "+destination);
			hanoiCalc(num-1,temp,destination,source);
		}
	}
	public static void main(String[] args){ 
		int num =3;
		hanoiCalc(num,'A','C','B');
	}
}