import com.netcracker.bertosh.dao.DefaultCourseDao;
import com.netcracker.bertosh.dao.CourseDao;
import com.netcracker.bertosh.entity.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CourseDaoTest {
    private static final int TEST_ID = 999;
    private static final String UPDATE_TEST_NAME = "UpdateTestName";
    private static final String UPDATE_TEST_TRAINER_NAME = "UpdateTestTrainerName";
    private static final String UPDATE_TEST_TRAINER_SURNAME = "UpdateTestTrainerSurname";
    private final int TEST_HOUR_COUNT = 15;
    private final String TEST_NAME = "TestName";
    private final String TEST_TRAINER_NAME = "TestTrainerName";
    private final String TEST_TRAINER_SURNAME = "TestTrainerSurname";

    private static CourseDao courseDao;
    private static Random random;

    private Course course = new Course();

    @BeforeClass
    public static void init() {
        courseDao = DefaultCourseDao.getInstance();
        random = new Random();
    }

    @Before
    public void createTestStudent() {
        course.setId(TEST_ID);
        course.setHoursCount(TEST_HOUR_COUNT);
        course.setName(TEST_NAME);
        course.setTrainerName(TEST_TRAINER_NAME);
        course.setTrainerSurname(TEST_TRAINER_SURNAME);
        courseDao.saveCourse(course);
    }

    @After
    public void removeTestStudent() {
        courseDao.delete(TEST_ID);
    }

    @Test
    public void saveStudent() throws Exception {
        course.setId(TEST_ID + 1);
        course.setHoursCount(TEST_HOUR_COUNT);
        course.setName(TEST_NAME);
        course.setTrainerName(TEST_TRAINER_NAME);
        course.setTrainerSurname(TEST_TRAINER_SURNAME);
        courseDao.saveCourse(course);

        Course course = courseDao.getCourseById(TEST_ID + 1);
        assertEquals(TEST_ID + 1, course.getId());
        assertEquals(TEST_NAME, course.getName());
        assertEquals(TEST_TRAINER_NAME, course.getTrainerName());
        assertEquals(TEST_TRAINER_SURNAME, course.getTrainerSurname());
        assertEquals(TEST_HOUR_COUNT, course.setHoursCount());

        courseDao.delete(TEST_ID + 1);
    }

    @Test
    public void getStudents() throws Exception {
        List<Course> students = courseDao.getCourses();
        assertNotNull(students);
        assertEquals(students.size(), 1);
    }

    @Test
    public void getStudent() throws Exception {
        Course course = courseDao.getCourseById(TEST_ID);
        assertNotNull(course);
    }

    @Test
    public void update() throws Exception {
        Course course = courseDao.getCourseById(TEST_ID);
        course.setName(UPDATE_TEST_NAME);
        course.setTrainerName(UPDATE_TEST_TRAINER_NAME);
        course.setTrainerSurname(UPDATE_TEST_TRAINER_SURNAME);
        courseDao.update(course);
        Course studentUpdate = courseDao.getCourseById(TEST_ID);
        assertEquals(UPDATE_TEST_NAME, studentUpdate.getName());
        assertEquals(UPDATE_TEST_TRAINER_NAME, studentUpdate.getTrainerName());
        assertEquals(UPDATE_TEST_TRAINER_SURNAME, studentUpdate.getTrainerSurname());
    }
}
