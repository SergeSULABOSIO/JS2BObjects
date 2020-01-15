/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Callbacks;

/**
 *
 * @author HP Pavilion
 */
public abstract class EcouteurSuppressionElement {
    public abstract void onDeletionComplete(int idElement, long signature);
    public abstract boolean onCanDelete(int idElement, long signature);
}






