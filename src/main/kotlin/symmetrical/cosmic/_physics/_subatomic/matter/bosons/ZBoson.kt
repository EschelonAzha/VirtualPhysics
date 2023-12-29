package symmetrical.cosmic._physics._subatomic.matter.bosons

import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics._subatomic.balanced.values.Field


open class ZBoson{
    constructor()

    // Neutral Charge
    // Spin 1
    // This boson transfers its spin, momentum and energy

    private var accepted     :Boolean   = true
    private var constructing :Boolean   = false
    private var newValue     :Field     = Field();
    private var oldValue     :Field     = Field()
    private var reason       :String    = ""
    private var reasonCode   :Int       = 0



    fun i(newValue: Field, constructing:Boolean = false) : ZBoson {
        this.newValue     = newValue
        this.constructing = constructing
        return this
    }
    fun decay() : TauAntiTauPair {
        return TauAntiTauPair().i(accepted, reasonCode, reason, newValue, oldValue)
    }
    fun getNewField() : Field {
        return this.newValue;
    }
    fun getNewValue() : Any? {
        return getNewField().getContent()
    }

    fun getOldField() : Field {
        return this.oldValue
    }
    fun getOldValue() : Any? {
        return getOldField().getContent()
    }
    fun isAccepted() : Boolean {
        return accepted
    }
    fun isConstructing() : Boolean {
        return constructing
    }
    fun setAccepted(accepted:  Boolean) : ZBoson {
        this.accepted = accepted
        return this
    }
    fun setNewValue(content:Any?) : ZBoson {
        this.newValue.setContent(content)
        return this
    }
    fun setOldValue(content:Any?) : ZBoson {
        this.oldValue.setContent(content)
        return this
    }
    fun setReason(reason:String) : ZBoson {
        this.reason = reason
        return this
    }
    fun setReasonCode(code:Int) : ZBoson {
        this.reasonCode = code
        return this
    }
}