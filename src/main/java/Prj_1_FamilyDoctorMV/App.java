import Prj_1_FamilyDoctorMV.controller.DoctorController;
import Prj_1_FamilyDoctorMV.repository.Repository;
import Prj_1_FamilyDoctorMV.ui.DoctorUI;

public class App {

	public static void main(String[] args) {
		String patients = "FilePatients.txt";
		String consultations = "FileConsultations.txt";
		Repository repo = new Repository(patients, consultations);
		DoctorController ctrl = new DoctorController(repo);
		
		DoctorUI console = new DoctorUI(ctrl);
		console.Run();
	}
}
