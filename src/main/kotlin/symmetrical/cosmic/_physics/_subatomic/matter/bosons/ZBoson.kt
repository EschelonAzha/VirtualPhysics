package symmetrical.cosmic._physics._subatomic.matter.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class ZBoson{
    constructor()

    // Neutral Charge
    // Spin 1
    // This boson transfers its spin, momentum and energy

    private var accepted     :Boolean   = true
    private var constructing :Boolean   = false
    private var newValue     :Field     = Field();
    private var oldValue     :Field     = Field()
    private var reasonCode   :Int       = 0
    private var reason       :String    = ""



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
        return getNewField().getValue()
    }

    fun getOldField() : Field {
        return this.oldValue
    }
    fun getOldValue() : Any? {
        return getOldField().getValue()
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
    fun setNewValue(value:Any?) : ZBoson {
        this.newValue.setValue(value)
        return this
    }
    fun setOldValue(value:Any?) : ZBoson {
        this.oldValue.setValue(value)
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