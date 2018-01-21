
public class Brad71 {

	public static void main(String[] args) {

		// label: + for, while, do
		brad: for (int j=0; j<4; j++) {
			for (int i=0; i<4; i++) {
				System.out.println(j + ":" + i);
				if (i==2 && j==2 ) {
					break brad;
				}
			}
		}
		
	}

}
