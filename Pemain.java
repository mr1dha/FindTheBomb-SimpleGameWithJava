public class Pemain{
	private String nama;
	private int nilai;

	public Pemain(){
//		this.nama = nama;
		nilai = 0;
	}

	public String getNama(){
		return nama;
	}

	public int getNilai(){
		return nilai;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public void setNilai(int nilaiBaru){
		nilai = nilaiBaru;
	}
	
	public void tambahNilai(){
		nilai += 5;
	}
        
        public String getGrade(){
            if(nilai > 35)
                return "Excellent";
            else if(nilai >= 15 && nilai <= 35)
                return "Good";
            else
                return "Bad";
        }
}