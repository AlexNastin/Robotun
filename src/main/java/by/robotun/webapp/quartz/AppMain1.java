package by.robotun.webapp.quartz;

import java.text.ParseException;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain1 {

	static {
		new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
	}

	public static void main(String args[]) throws ParseException, ClassNotFoundException, SchedulerException {

//        Reflections reflections = new Reflections("by.st.mc21.quartz.job");
//
//        Set<Class<? extends Object>> classes = reflections.getTypesAnnotatedWith(QuartzJobMC21.class);
//        System.out.println("!!!!!");
//        System.out.println(classes.size());
//        for (Class<? extends Object> allClasse : classes) {
////             System.out.println(allClasse.getClass());
//             System.out.println(allClasse.getCanonicalName());
//              System.out.println(allClasse.getAnnotation(QuartzJobMC21.class).nameJob());
//        }
//        System.out.println("__________");
//       
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/data.xml");

        StdScheduler stdScheduler = (StdScheduler) context.getBean("stdScheduler");
        JobKey jobKey2 = new JobKey("JOB12345");
       System.err.println(stdScheduler.getJobDetail(jobKey2));
        stdScheduler.start();
//        QuartzSchedulerMC21 mC21 = context.getBean(QuartzSchedulerMC21.class);

//        StdScheduler stdScheduler = (StdScheduler) mC21.getScheduler();

//        List<JobMC21> jobMC21s = mC21.getAllJobs();
//        System.out.println(jobMC21s.size());
//        for (JobMC21 jobMC21 : jobMC21s) {
//            System.out.println(jobMC21.toString());
//        }
//        for (JobKey jobKey : stdScheduler.getJobKeys(GroupMatcher.jobGroupEquals("DEFAULT"))) {
//
//            String jobName = jobKey.getName();
//
//            //get job's trigger
//            List<CronTriggerImpl> triggers = (List<CronTriggerImpl>) stdScheduler.getTriggersOfJob(jobKey);
//
//            System.out.println("[jobName] : " + jobName);
//
//            for (CronTriggerImpl trigger : triggers) {
//                System.out.println("[trigger] : " + trigger.getCronExpression());
//                System.out.println("[triggerJOB] : " + trigger.getJobName());
//                for (JobKey jobKey2 : stdScheduler.getJobKeys((GroupMatcher<JobKey>) groupEquals("DEFAULT"))) {
////                    jobKey2.
//                }
//            }
//
//        }
//        if (mC21 == null) {
//            System.out.println("NULL");
//        } else {
//
//            System.out.println("OK!!!!!!!!!!");
////            mC21.addSchedulerJob("JS1", "0/15 * * * * ?", "by.st.mc21.quartz.job.ScheduledJob1");
//          List<JobDetailImpl> d=   mC21.getAllJobs();
//            for (int i = 0; i < d.size(); i++) {
//                System.out.println(  d.get(i).getFullName());
//            }
////            mC21.updateSchedulerJob("JS1", "0/10 * * * * ?", "by.st.mc21.quartz.job.ScheduledJob1");
//
//        }
        JobKey jobKey = new JobKey("JOB1234");
        TriggerKey triggerKey = new TriggerKey("T1234");
        JobDetailImpl jobDetailImpl = new JobDetailImpl();
        jobDetailImpl.setKey(jobKey);
       Class<?> csa =  Class.forName("by.robotun.webapp.quartz.ScheduledJob1");
        jobDetailImpl.setJobClass((Class<? extends Job>) csa);
        
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        cronTriggerImpl.setJobKey(jobKey);
        cronTriggerImpl.setKey(triggerKey);
        cronTriggerImpl.setCronExpression("0/1 * * * * ?");
      
        stdScheduler.scheduleJob(jobDetailImpl, cronTriggerImpl);

	}    }