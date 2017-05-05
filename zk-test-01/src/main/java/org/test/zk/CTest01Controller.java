package org.test.zk;

import org.test.zk.dao.CPerson;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.ItemRenderer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Selectbox;
import org.zkoss.zul.Window;

public class CTest01Controller extends SelectorComposer<Component> implements ItemRenderer<CPerson> {

	private static final long serialVersionUID = -258902408111073465L;
	
	@Wire
	Button buttonTest01;
	
	@Wire ("#buttonMiSuperBotton")
	Button buttonTest02;
	
	@Wire
	Selectbox selectBox01;
	
	@Wire
	Selectbox selectBox02;
	
	@Wire
	Window windowsTest01;
	
	protected ListModelList<String> dataModel = new ListModelList<String>();
	protected ListModelList<CPerson> dataModelCPerson = new ListModelList<CPerson>();
	
	
	@Listen("onClick=#buttonTest01")
	public void onClicButtonTest01(Event event){
		windowsTest01.setTitle("esta bien");
		buttonTest02.setLabel("Funciona!");
		dataModel.add("1");
		dataModel.add("2");
		dataModel.add("3");
		dataModel.add("4");
		dataModel.add("5");
		
		dataModelCPerson.add(new CPerson("1","jean","Newman"));
		dataModelCPerson.add(new CPerson("1","rossiel","Newman"));
		dataModelCPerson.add(new CPerson("1","Rodriguez","Newman"));
		
		selectBox02.setModel(dataModelCPerson);
		selectBox02.setItemRenderer(this);
		//dataModel.addToSelection();
		
		selectBox01.setModel(dataModel);
		dataModel.addToSelection("1");
		selectBox01.setSelectedIndex(0);
		
		
		
	}
	
	@Listen("onClick=#buttonMiSuperBotton")
	public void onClicButtonTest02(Event event){
		//windowsTest01.setTitle("esta bien");
		buttonTest02.setLabel("Funciona!");
	}
	
	@Listen("onClick=#buttonTest03")
	public void onClicButtonMakeModal(Event event){
		windowsTest01.doModal();
		windowsTest01.setSizable(true);
		//windowsTest01.
		buttonTest02.setLabel("Funciona!");
		
	}
    @Listen("onSelect=#selectBox01")
    public void onSelectselectBox01(Event event){
    	
      if(selectBox01.getSelectedIndex()>= 0){
    	  windowsTest01.setTitle(dataModel.get(selectBox01.getSelectedIndex()));
      }
    }
    
    @Listen("onSelect=#selectBox02")
    public void onSelectselectBox02(Event event){
    	
      if(selectBox02.getSelectedIndex()>= 0){
    	  CPerson personSelected = dataModelCPerson.get(selectBox02.getSelectedIndex());
    	  windowsTest01.setTitle(personSelected.getId());
      }
    }

	public String render(Component arg0, CPerson arg1, int arg2) throws Exception {
		// TODO Auto-generated method stub
		return arg1.getFirstName()+ " " + arg1.getStrLastName();
	}
}
