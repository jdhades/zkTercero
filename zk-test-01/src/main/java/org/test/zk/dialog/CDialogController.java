package org.test.zk.dialog;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Selectbox;
import org.zkoss.zul.Textbox;

public class CDialogController extends SelectorComposer<Component> {

	
	private static final long serialVersionUID = -8977563222707532143L;
	
	protected ListModelList<String> dataModel = new ListModelList<String>();
	
	
	@Wire
	Label labelId;

	@Wire
	Textbox textboxId;
	
	@Wire
	Label labelNombre;

	@Wire
	Textbox textboxNombre;

	@Wire
	Label labelApellido;

	@Wire
	Textbox textboxApellido;

	@Wire
	Label labelFechadeNacimiento;

	@Wire
	Datebox dateboxFechadeNacimiento;

	@Wire
	Label labelGenero;
	
	@Wire
	Selectbox selectboxGenero;
	
	@Wire
	Label labelComentario;
	
	@Wire
	Textbox textboxComentario;
	
	@Override
	 public void doAfterCompose(Component comp) {
	      try {
			super.doAfterCompose(comp);
			
			dateboxFechadeNacimiento.setFormat("dd-MM-yyyy");
			dataModel.add("Femenino");
			dataModel.add("Masculino");
			
			selectboxGenero.setModel(dataModel);
			selectboxGenero.setSelectedIndex(0);
			
			dataModel.addToSelection("Femenino");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	      //do whatever you want (you could access wired variables here)
	   }
	
	
	@Listen ("onClick=#buttonAceptar")
	public void onClickButtonAceptar(Event event){
		
		Messagebox.show(textboxId.getValue()+" Nombre: " + textboxNombre.getValue()+" Apellido:"+textboxApellido.getValue()+" Comentario:"+textboxComentario.getValue(), "Aceptar", Messagebox.OK, Messagebox.INFORMATION);
		
		//System.out.println("hello aceptar");
		
	}
	
	@Listen ("onClick=#buttonCancelar")
	public void onClickButtonCancelar(Event event){
	
		Messagebox.show("Cancelar", "Cancelar", Messagebox.OK, Messagebox.EXCLAMATION);
			
	}
	
}
