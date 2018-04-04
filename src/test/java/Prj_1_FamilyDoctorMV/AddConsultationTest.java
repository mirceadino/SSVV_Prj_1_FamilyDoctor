package Prj_1_FamilyDoctorMV;

import Prj_1_FamilyDoctorMV.controller.DoctorController;
import Prj_1_FamilyDoctorMV.exceptions.ConsultationException;
import Prj_1_FamilyDoctorMV.repository.Repository;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AddConsultationTest
        extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public AddConsultationTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(AddConsultationTest.class);
  }

  /**
   * Rigourous Test :-)
   */
  public void testAddNullMedsConsultation() {
    Repository repo = new Repository("mock-FilePatients.txt", "mock-FileConsultations.txt");
    DoctorController ctrl = new DoctorController(repo);
    repo.cleanFiles();

    try {
      ctrl.addConsultation("", "", "", null, "");
      assertTrue(false);
    } catch (ConsultationException err) {
      assertEquals(0, ctrl.getConsultationList().size());
    }
  }

  public void testAddInvalidArgumentsConsultation() {
    Repository repo = new Repository("mock-FilePatients.txt", "mock-FileConsultations.txt");
    DoctorController ctrl = new DoctorController(repo);
    repo.cleanFiles();

    try {
      List<String> meds = new ArrayList<String>();
      ctrl.addConsultation("11", "11", "11", meds, "11.01.2011");
      assertTrue(false);
    } catch (ConsultationException err) {
      assertEquals(0, ctrl.getConsultationList().size());
    }
  }
}
