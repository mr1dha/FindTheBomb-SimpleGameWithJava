import java.util.Arrays;

public class Lapangan{
	private int jumlahKotak;
	private int[] kotak;

	public Lapangan(){
		jumlahKotak = 10;
		buatKotak();
	}

	public Lapangan(int jumKotak){
		jumlahKotak = jumKotak;
		buatKotak();
	}

	private void buatKotak(){
		kotak = new int[100];
		Arrays.fill(kotak, 0);

		for(int i=0; i<10; i++){
			tambahItem((int) (Math.random() * 100) + 1);
		}
	}

	public void tambahItem(int posisi){
		kotak[posisi-1] = 1;
	}

	public boolean adaItem(int posisi){
		return kotak[posisi-1] == 1;
	}

	public void hapusItem(int posisi){
		kotak[posisi-1] = 0;
	}
}