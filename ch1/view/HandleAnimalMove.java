package ch1.view;
import java.awt.event.*;
import javax.swing.JOptionPane;
import ch1.data.Point;
import ch1.data.Animal;
import ch1.data.ViewForAnimal;
import ch1.data.LeftAnimal;
import ch1.data.RightAnimal;
public class HandleAnimalMove extends MouseAdapter {
     GamePanel panel;
     HandleAnimalMove(GamePanel panel){
        this.panel = panel;
     } 
     public void mousePressed(MouseEvent e){
        ViewForAnimal animalView = (ViewForAnimal)e.getSource();
        Animal animal = animalView.getAnimal();
        Point pStart = animal.getAtPoint(); //�õ������ƶ�ǰ���ڵ�
        if(animal.move()) {
           Point pEnd = animal.getAtPoint();//�õ������ƶ������ڵ�
           int x = pEnd.getX();
           int y = pEnd.getY();
           animalView.setAnimalViewLocation(x,y);//�ö�����ͼ����λ�úͶ������ڵ���ͬ
           panel.saveAnimalStep.push(pStart);
           panel.saveAnimalStep.push(pEnd);
        }
    } 
    public void mouseReleased(MouseEvent e){
         boolean success = true;
         int n =panel.animalCount/2;
         for(int i=0;i<n;i++){
            Animal animal=panel.point[i].getAtPointAnimal();
            success = success&&(animal instanceof RightAnimal);
            animal=panel.point[n+1+i].getAtPointAnimal();
            success = success&&(animal instanceof LeftAnimal);
            if(success == false)
              break;
         }
         if(success) {
            JOptionPane.showMessageDialog(null,"���ɹ���","��Ϣ��",
                                             JOptionPane.INFORMATION_MESSAGE); 
         }
    }
}