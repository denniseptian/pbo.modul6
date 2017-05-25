package application;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Processed {
	ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();

	public void tambah(String Nim, String Nama, String Fakultas, String Jurusan, String Alamat, String Kota,
			String KodePos, String Hobby) {
		System.out.println("Data come!");
		if (mahasiswa.size() == 0) {
			mahasiswa.add(new Mahasiswa(Nim, Nama, Fakultas, Jurusan, Alamat, Kota, KodePos, Hobby));
			JOptionPane.showMessageDialog(null, "Tersimpan!");
		} else {

			for (int i = 0; i < mahasiswa.size(); i++) {
				if (Nim.equals(mahasiswa.get(i).getNim())) {
					JOptionPane.showMessageDialog(null, "Data sudah ada!");

					System.out.println("Over coming but not save!");
					break;
				} else if (!Nim.equals(mahasiswa.get(i).getNim()) && i == mahasiswa.size() - 1) {
					mahasiswa.add(new Mahasiswa(Nim, Nama, Fakultas, Jurusan, Alamat, Kota, KodePos, Hobby));
					JOptionPane.showMessageDialog(null, "Tersimpan!");
					System.out.println("Over here!");
					break;
				}
			}
		}
	}

	public void show() {
		if (mahasiswa.size() > 0) {
			for (int i = 0; i < mahasiswa.size(); i++) {
				System.out.println(mahasiswa.get(i).getNim());
				System.out.println(mahasiswa.get(i).getNama());
				System.out.println(mahasiswa.get(i).getFakultas());
				System.out.println(mahasiswa.get(i).getJurusan());
				System.out.println(mahasiswa.get(i).getAlamat());
				System.out.println(mahasiswa.get(i).getKota());
				System.out.println(mahasiswa.get(i).getKodePos());
				System.out.println(mahasiswa.get(i).getHobby());

				System.out.println("------------------------------------");
			}
		} else
			JOptionPane.showMessageDialog(null, "Tidak ada data!");
	}

	public void remove(String nim) {
		for (int i = 0; i < mahasiswa.size(); i++) {
			if (mahasiswa.size() == 0) {
				JOptionPane.showMessageDialog(null, "No data available!");

			} else if (mahasiswa.get(i).getNim().equals(nim)) {
				mahasiswa.remove(i);
				JOptionPane.showMessageDialog(null, "Deleted!");
				break;
			}
		}
	}
	
	public Mahasiswa get(String nim) {
		Mahasiswa data = null;
		for (int i = 0; i < mahasiswa.size(); i++) {
			if (mahasiswa.size() == 0) {
				JOptionPane.showMessageDialog(null, "No data available!");

			} else if (mahasiswa.get(i).getNim().equals(nim)) {
				data = mahasiswa.get(i);
			}
		}
		return data;
	}
	
	public void update(String key, Mahasiswa onCome){
		for (int i = 0; i < mahasiswa.size(); i++) {
			if (mahasiswa.size() == 0) {
				JOptionPane.showMessageDialog(null, "No data available!");

			} else if (mahasiswa.get(i).getNim().equals(key)) {
				//here
				mahasiswa.set(i, onCome);
			}
		}
	}

	public ArrayList<Mahasiswa> getAll() {
		return mahasiswa;
	}
}
