
package examplesbehaviours;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
public class SimpleAgent extends Agent {
    private class FourStepBehaviour extends Behaviour {
// SimpleBehaviour hello_behaviour = new SimpleBehaviour(this){ ����������кܴ�ͬ������Ķ���һ���µ��࣬������޸��˱�׼��Ϊ��ִ������
        private int step = 1;
        public void action() {
            switch (step) {
                case 1:
                    System.out.println("Operation 1");
                    break;
                case 2:
                    System.out.println("Operation 2. Adding one-shot behaviour");
                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
//������һ���µĶ�����������
                        public void action() {
                            System.out.println("One-shot");
                        } 
                    });// myAgent.addbehaviour
                    break;
                case 3:
                    System.out.println("Operation 3");
                    break;
                case 4:
                    System.out.println("Operation 4");
                    break;
             }//switch
             step++;
        } //action

        public boolean done() {
            return step == 5; //�ж����
        } 

        public int onEnd() {
            myAgent.doDelete();
            System.out.println("Finished!");
            return super.onEnd(); } 
}    // class FourStepBehaviour
/** Creates a new instance of SimpleAgent */
    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new CyclicBehaviour(this) { //������һ��ѭ����Ϊ
            public void action() {
                System.out.println("Cycling");} 
        }); // //���ӵ�ѭ����Ϊ
        // Add the generic behaviour
     addBehaviour(new FourStepBehaviour());
    }////setup()
}//
