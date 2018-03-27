package Prj_1_FamilyDoctorMV;

import Prj_1_FamilyDoctorMV.controller.DoctorController;
import Prj_1_FamilyDoctorMV.exceptions.PatientException;
import Prj_1_FamilyDoctorMV.model.Patient;
import Prj_1_FamilyDoctorMV.repository.Repository;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AddPatientTest
        extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public AddPatientTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(AddPatientTest.class);
  }

  /**
   * Rigourous Test :-)
   */
  public void testAddValidPatient() {
    Repository repo = new Repository("mock-FilePatients.txt", "mock-FileConsultations.txt");
    DoctorController ctrl = new DoctorController(repo);
    repo.cleanFiles();

    try {
      ctrl.addPatient(new Patient("George Hora", "1900505050005", "9 George Hora"));
      assertEquals(ctrl.getPatientList().size(), 1);
    } catch (PatientException err) {
      assertTrue(false);
    }

    try {
      ctrl.addPatient(new Patient("Mihai Radu", "invalid", "9 Mihai Radu"));
      assertTrue(false);
    } catch (PatientException err) {
      assertEquals(ctrl.getPatientList().size(), 1);
    }
  }
}
