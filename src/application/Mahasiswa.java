package application;

public class Mahasiswa {
	private String nim;
	private String nama;
	private String fakultas;
	private String jurusan;
	private String alamat;
	private String kota;
	private String kodePos;
	private String hobby;
	
	public Mahasiswa() {
		// TODO Auto-generated constructor stub
	}
	
	public Mahasiswa(String Nim, String Nama, String Fakultas, String Jurusan, String Alamat, String Kota,
			String KodePos, String Hobby){
		
		setNim(Nim);
		setNama(Nama);
		setFakultas(Fakultas);
		setJurusan(Jurusan);
		setAlamat(Alamat);
		setKota(Kota);
		setKodePos(KodePos);
		setHobby(Hobby);
	}
	
	public Mahasiswa(String Nim, String KodePos, String Hobby){
		
		setNim(Nim);
		setKodePos(KodePos);
		setHobby(Hobby);
	}
	
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getFakultas() {
		return fakultas;
	}
	public void setFakultas(String fakultas) {
		this.fakultas = fakultas;
	}
	public String getJurusan() {
		return jurusan;
	}
	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getKodePos() {
		return kodePos;
	}
	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
