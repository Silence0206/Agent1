
package examplesbehaviours;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
public class SimpleAgent extends Agent {
    private class FourStepBehaviour extends Behaviour {
// SimpleBehaviour hello_behaviour = new SimpleBehaviour(this){ 这两条语句有很大不同吗？上面的定义一个新的类，下面的修改了标准行为的执行内容
        private int step = 1;
        public void action() {
            switch (step) {
                case 1:
                    System.out.println("Operation 1");
                    break;
                case 2:
                    System.out.println("Operation 2. Adding one-shot behaviour");
                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
//增加了一个新的动作，即快照
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
            return step == 5; //判断语句
        } 

        public int onEnd() {
            myAgent.doDelete();
            System.out.println("Finished!");
            return super.onEnd(); } 
}    // class FourStepBehaviour
/** Creates a new instance of SimpleAgent */
    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new CyclicBehaviour(this) { //增加了一个循环行为
            public void action() {
                System.out.println("Cycling");} 
        }); // //增加的循环行为
        // Add the generic behaviour
     addBehaviour(new FourStepBehaviour());
    }////setup()
}//
