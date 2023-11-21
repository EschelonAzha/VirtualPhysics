package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Tau
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class TauAntiTauPair(
    private val fermion: IFermion = Fermion(TauAntiTauPair::class),
) : LeptonPair(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(TauAntiTauPair::class),
    )

    var reasonCode : Int        = 0
    var reason     : String     = ""
    var accepted   : Boolean    = true


    constructor(lepton: Lepton, antiLepton: AntiLepton) : this() {
        i(lepton, antiLepton)
    }
    fun i(accepted:Boolean, reasonCode:Int, reason:String, newValue: Field, oldValue: Field) : TauAntiTauPair {
        super.i(Tau(newValue), AntiTau(oldValue))
        this.accepted       = accepted
        this.reasonCode     = reasonCode
        this.reason         = reason
        return this
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }

    fun decay(pion: PlusPion) : TauAntiTauPair {
        return this
    }

    fun getElectron() : Electron {
        return lepton as Electron
    }
    fun getPositron() : Positron {
        return antiLepton as Positron
    }
    //    private fun setElectron(electron: Electron) : ElectronPositron<PlusPion> {
//        this.leptons[0] = electron
//        return this
//    }
//    private fun setPositron(positron: Positron) : ElectronPositron<PlusPion> {
//        this.leptons[1] = positron
//        return this
//    }
    private fun setElectron(electron: Electron) : TauAntiTauPair {
        this.lepton = electron
        return this
    }
    private fun setPositron(positron: Positron) : TauAntiTauPair {
        this.antiLepton = positron
        return this
    }

}