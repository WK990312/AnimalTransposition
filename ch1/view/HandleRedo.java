package ch1.view;
import ch1.data.Point;
import ch1.data.Animal;
import ch1.data.ViewForAnimal;
import java.awt.event.*;
public class HandleRedo implements ActionListener {
     GamePanel panel;
     HandleRedo(GamePanel panel){
        this.panel = panel;
     } 
     public void actionPerformed(ActionEvent e){ //�����ƶ�����Ĳ���
           if(panel.saveAnimalStep.empty())
               return;
           Point pEnd = panel.saveAnimalStep.pop();
           Point pStart = panel.saveAnimalStep.pop();
           Animal animal = pEnd.getAtPointAnimal(); 
           pEnd.setIsHaveAnimal(false);
           pEnd.setAtPointAnimal(null);
           animal.setAtPoint(pStart);
           ViewForAnimal animalView =animal.getAnimalView();
           int x = pStart.getX();
           int y = pStart.getY();
           animalView.setAnimalViewLocation(x,y);//�ö�����ͼ����λ�úͶ������ڵ���ͬ
    } 
}