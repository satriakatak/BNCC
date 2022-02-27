import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner (System.in);

	public Main() {
		
		Vector<gaji> vGaji = new Vector<>();
		
		int choose = 0 ;
		do {

			System.out.println("Choose : ");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete data Karyawan");
			choose = scan.nextInt(); scan.nextLine();
			
			switch (choose) {
			
//			input
			case 1:
				
				String nama, kelamin, jabatan = "";
				do {
					System.out.print("Input nama karyawan [>=3] :");
					nama = scan.nextLine();
					
				} while (nama.length()<3);
				
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (case Sensitive) : ");
					kelamin = scan.nextLine();
					
				} while (!kelamin.contentEquals("Laki-laki") && !kelamin.equals("Perempuan"));
				
				
				
				do {
					System.out.print("Input jabatan [ Manager | Supervisor | Admin ] : ");
					jabatan = scan.nextLine();

				} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
				
				
			
				int gaji =  0;

				
				if (vGaji.size() > 0) {
					
					if (jabatan.equals("Manager")   ) {
						gaji = 8800000 ;
					} if (jabatan.equals("Supervisor") ) {
						gaji = 6450000;
					} if (jabatan.equals("Admin") ) {
						gaji = 4200000;
					}
					
				
					
					
				} else {
					
					if (jabatan.equals("Manager") ) {
						gaji = 8000000 ;
					} if (jabatan.equals("Supervisor")) {
						gaji = 6000000;
					} if (jabatan.equals("Admin")) {
						gaji = 4000000;
					}
					
				}					
				
				
				
				
				Random r = new Random();
				char c = (char)(r.nextInt(26) + 'a');
				
				Random z = new Random();
				char d = (char)(r.nextInt(26) + 'a');
				
				String newC = String.valueOf(c);
				newC.toUpperCase();
				String newD = String.valueOf(d);
				newD.toUpperCase();
				
				int max = 9999 ;
				int min = 1000 ;
				
				int num = (int) (Math.random() * (max + 1 - min)) + min;	
				String.valueOf(num);
				
				String simpanId = newC.toUpperCase() + newD.toUpperCase() + "-" + num ;
			
	
				System.out.println("Berhasil menambahkan karykawan dengan ID : " + simpanId );
				
				
				gaji newGaji = new gaji ();
				newGaji.setKelamin(kelamin);
				newGaji.setNama(nama);
				newGaji.setSimpandId(simpanId);
				newGaji.setJabatan(jabatan);
				newGaji.setGaji(gaji);
				
				vGaji.add(newGaji);
				
				
				break;
//			view
			case 2:
				
				if (vGaji.isEmpty()) {
					System.out.println("empty photo list");
				} else {
					
					for (int i = 0; i < vGaji.size()-1; i++) {
						for (int j = 0; j <vGaji.size()-i-1; j++) {
							String menuIdx1 = vGaji.get(j).getNama();
							String menuIdx2  = vGaji.get(j+1).getNama();
							
							if (menuIdx1.charAt(0) > menuIdx2.charAt(0)) {
								
								gaji temp = vGaji.get(j);
								vGaji.set(j, vGaji.get(j+1));
								vGaji.set(j+1, temp);					
							}

							}	

						}
								
					for (int i1 = 0; i1 < vGaji.size(); i1++) {
						System.out.println("No :" + (i1+1));
						System.out.println("Kode Karyawan :" + vGaji.get(i1).getSimpandId());
						System.out.println("Nama Karyawan : " + vGaji.get(i1).getNama());
						System.out.println("Jenis Kelamin : " + vGaji.get(i1).getKelamin());
						System.out.println("Jabatan       : " + vGaji.get(i1).getJabatan());
						System.out.println("Gaji Karyawan : " + vGaji.get(i1).getGaji());
						System.out.println();
								
														
					}			
				}
				
				
				break;
				
//			update
			case 3:
				
				if (vGaji.isEmpty()) {
					System.out.println("empty list");
				} else {
					
					for (int i = 0; i < vGaji.size()-1; i++) {
						for (int j = 0; j <vGaji.size()-i-1; j++) {
							String menuIdx1 = vGaji.get(j).getNama();
							String menuIdx2  = vGaji.get(j+1).getNama();
							
							if (menuIdx1.charAt(0) > menuIdx2.charAt(0)) {
								
								gaji temp = vGaji.get(j);
								vGaji.set(j, vGaji.get(j+1));
								vGaji.set(j+1, temp);					
							}

							}	

						}
								
					for (int i1 = 0; i1 < vGaji.size(); i1++) {
						System.out.println("No :" + (i1+1));
						System.out.println("Kode Karyawan :" + vGaji.get(i1).getSimpandId());
						System.out.println("Nama Karyawan : " + vGaji.get(i1).getNama());
						System.out.println("Jenis Kelamin : " + vGaji.get(i1).getKelamin());
						System.out.println("Jabatan       : " + vGaji.get(i1).getJabatan());
						System.out.println("Gaji Karyawan : " + vGaji.get(i1).getGaji());
						System.out.println();
								
														
					}	
					
					int chooseNo = -1 ; 
					int flag = 0 ; 
					
					do {
						System.out.println("choose data you'd to update");
						chooseNo = scan.nextInt(); scan.nextLine();
						flag = 0;
						
						if (vGaji.isEmpty()) {
							System.out.println("data not found!");
							System.out.println("press enter to continue");
							scan.nextLine();
							flag = 1;
						}
						if (chooseNo > vGaji.size()) {
							System.out.println("please available data");
							System.out.println("press enter to continue");
							scan.nextLine();
							flag = 2; 
						}

						
						
					} while (flag==2);
					
					
					
					String namaUpdate, kelaminUpdate, jabatanUpdate = "";
					do {
						System.out.print("Input nama karyawan [>=3] :");
						namaUpdate = scan.nextLine();
						
						
					} while (namaUpdate.length()<3);
					
					do {
						System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (case Sensitive) : ");
						kelaminUpdate = scan.nextLine();
						
					} while (!kelaminUpdate.contentEquals("Laki-laki") && !kelaminUpdate.equals("Perempuan"));
					
					
					
					do {
						System.out.print("Input jabatan [ Manager | Supervisor | Admin ] : ");
						jabatanUpdate = scan.nextLine();

					} while (!jabatanUpdate.equals("Manager") && !jabatanUpdate.equals("Supervisor") && !jabatanUpdate.equals("Admin"));
					
					
				
					int gajiUpdate =  0;

					
					if (vGaji.size() > 0) {
						
						if (jabatanUpdate.equals("Manager")   ) {
							gajiUpdate = 8800000 ;
						} if (jabatanUpdate.equals("Supervisor") ) {
							gajiUpdate = 6450000;
						} if (jabatanUpdate.equals("Admin") ) {
							gajiUpdate = 4200000;
						}
						
						
					} else {
						
						if (jabatanUpdate.equals("Manager") ) {
							gajiUpdate = 8000000 ;
						} if (jabatanUpdate.equals("Supervisor")) {
							gajiUpdate = 6000000;
						} if (jabatanUpdate.equals("Admin")) {
							gajiUpdate = 4000000;
						}
						
					}					
					
					
					
					
					Random rUpdate = new Random();
					char cUpdate = (char)(rUpdate.nextInt(26) + 'a');
					
					Random zUpdate = new Random();
					char dUpdate = (char)(rUpdate.nextInt(26) + 'a');
					
					String newCUpdate = String.valueOf(cUpdate);
					newCUpdate.toUpperCase();
					String newDUpdate = String.valueOf(dUpdate);
					newDUpdate.toUpperCase();
					
					int maxUpdate = 9999 ;
					int minUpdate = 1000 ;
					
					int numUpdate = (int) (Math.random() * (maxUpdate + 1 - minUpdate)) + minUpdate;	
					String.valueOf(numUpdate);
					
					String simpanIdUpdate = newCUpdate.toUpperCase() + newDUpdate.toUpperCase() + "-" + numUpdate ;
				
		
					
					
					
					chooseNo = --chooseNo ;
					
//					newGaji.setKelamin(kelamin);
//					newGaji.setNama(nama);
//					newGaji.setSimpandId(simpanId);
//					newGaji.setJabatan(jabatan);
//					newGaji.setGaji(gaji);
					
					
					vGaji.get(chooseNo).setGaji(gajiUpdate);
					vGaji.get(chooseNo).setJabatan(jabatanUpdate);
					vGaji.get(chooseNo).setKelamin(kelaminUpdate);
					vGaji.get(chooseNo).setNama(namaUpdate);
					vGaji.get(chooseNo).setSimpandId(simpanIdUpdate);
					
					System.out.println("Berhasil Mengupdate Karyawn dengan ID  : " + simpanIdUpdate );

					
					
				}
				
				
				

				
				break;
				
//			delete
			case 4:
			
				if (vGaji.isEmpty()) {
					System.out.println("Data not found!");
				} else {
					
					for (int i = 0; i < vGaji.size()-1; i++) {
						for (int j = 0; j <vGaji.size()-i-1; j++) {
							String menuIdx1 = vGaji.get(j).getNama();
							String menuIdx2  = vGaji.get(j+1).getNama();
							
							if (menuIdx1.charAt(0) > menuIdx2.charAt(0)) {
								
								gaji temp = vGaji.get(j);
								vGaji.set(j, vGaji.get(j+1));
								vGaji.set(j+1, temp);					
							}

							}	

						}
								
					for (int i1 = 0; i1 < vGaji.size(); i1++) {
						System.out.println("No :" + (i1+1));
						System.out.println("Kode Karyawan :" + vGaji.get(i1).getSimpandId());
						System.out.println("Nama Karyawan : " + vGaji.get(i1).getNama());
						System.out.println("Jenis Kelamin : " + vGaji.get(i1).getKelamin());
						System.out.println("Jabatan       : " + vGaji.get(i1).getJabatan());
						System.out.println("Gaji Karyawan : " + vGaji.get(i1).getGaji());
						System.out.println();
								
														
					}	
					
					int chooseNo = 0 ; 
					
					
//					do {
						System.out.println("input nomor karyawan yang ingin dihapus");
						chooseNo = scan.nextInt(); scan.nextLine();
						chooseNo = -1;

						vGaji.remove(chooseNo);

						
//						} while (chooseNo >1 || chooseNo > vGaji.size());
					
						System.out.println("karyawan dengan kode " + vGaji.get(chooseNo).getSimpandId()+ " berhasil dihapus");
						System.out.println("ENTER to return");
						scan.nextLine();
						break;
						
					
				}
				
				
			case 5: 

				System.out.println("thank you for using this application");
				System.out.println("press enter to continue");
				scan.nextLine();		
				break;
				
				
			}
			

			
		} while (choose!=4);
		
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
