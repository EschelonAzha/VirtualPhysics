package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Tau
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.MatterAntiMatter
/*
https://en.wikipedia.org/wiki/Pair_production
 */
class TauAntiTauPair(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(TauAntiTauPair::class, TauAntiTauPair::class),
) : LeptonPair(),
    IMatterAntiMatter by matterAntiMatter
{
    constructor() : this(
        MatterAntiMatter(TauAntiTauPair::class, TauAntiTauPair::class),
    ) init {
        setAccepted(true)
        setReason("")
        setReasonCode(0)
    }

    companion object {
        fun field(pair:LeptonPair) : Field {
            return pair._lepton.getWavelength().getField()
        }
        fun _field(pair:LeptonPair) : Field {
            return pair._antiLepton.getWavelength().getField()
        }
    }



    constructor(lepton: Lepton, antiLepton: AntiLepton) : this() {
        i(lepton, antiLepton)
    }
    fun i(accepted:Boolean, reasonCode:Int, reason:String, newValue: Field, oldValue: Field) : TauAntiTauPair {
        super.i(Tau(newValue), AntiTau(oldValue))
        setAccepted(accepted)
        setReasonCode(reasonCode)
        setReason(reason)
        return this
    }

    fun decay(pion: PlusPion) : TauAntiTauPair {
        return this
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getElectron() : Electron {
        return _lepton as Electron
    }
    fun getField() : Field {
        return TauAntiTauPair.field(this)
    }
    fun getAntiField() : Field {
        return TauAntiTauPair._field(this)
    }
    fun getPositron() : Positron {
        return _antiLepton as Positron
    }

    fun getReason() : String {
        return getWavelength().getField().toString()
    }

    fun getReasonCode() : Int {
        return getTemperature().getField().toInt()
    }

    fun isAccepted() : Boolean {
        return getSpin().isPlus()
    }
    fun setAccepted(accepted:Boolean) : TauAntiTauPair {
        getSpin().setSpin(accepted)
        return this
    }

    fun setReason(content:String) : TauAntiTauPair {
        getWavelength().setContent(content)
        return this
    }
    fun setReasonCode(value:Int) : TauAntiTauPair {
        getTemperature().setContent(value)
        return this
    }
    private fun setElectron(electron: Electron) : TauAntiTauPair {
        this._lepton = electron
        return this
    }
    private fun setPositron(positron: Positron) : TauAntiTauPair {
        this._antiLepton = positron
        return this
    }

}