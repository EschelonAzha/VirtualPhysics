package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals

class Electron : Lepton {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    lateinit var orbitals : Orbitals

    private lateinit var proton         : Proton
    private          var particleBeam   : ParticleBeam = ParticleBeam()

    constructor() {
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Electron::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i(orbitals:Orbitals) : Electron {
        super.i()
        this.orbitals = orbitals
        return this
    }

    fun setOrbitals(orbitals: Orbitals) : Electron {
        this.orbitals = orbitals
        return this
    }

//    fun flow() : ParticleBeam {
//        val result : ParticleBeam = ParticleBeam()
//        for (i:Int in 0 until particleBeam.size()) {
//
//            val electron = particleBeam.get(i) as Electron
//            result.add(flow(electron))
//        }
//
//        return result
//    }
//    private fun flow(electron:Electron) : ZBoson {
//        val terminal: Proton? = electron!!.proton
//
//        if (terminal == null)
//            return ZBoson(proton.getField())
//        if (electron.fundamentals.spin.spin == Spin.Static.PLUS)
//            return terminal.interact(ZBoson(proton.getField()))
//        else return terminal.capacitanceChange(ZBoson(proton.getField()).setOldValue(terminal.getValue()))
//
//    }
//    fun getSpin() : Int {
//        return fundamentals.spin.spin
//    }
//
//    fun setProton(proton: Proton) : Electron {
//        this.proton = proton
//        return this
//    }
//    fun setSpin(spin:Int) : Electron {
//        fundamentals.spin.spin = spin
//        return this
//    }
//    private fun setElectron(electron:Electron) : Electron {
//        val pos = particleBeam.find(electron)
//        if (pos == -1)
//            particleBeam.add(electron)
//
//        return this
//    }
//    fun covalentBond(you:Electron) : Electron {
//        you.setElectron(this)
//        this.setSpin(Spin.Static.PLUS)
//        return this
//    }
//    fun ionicBond(you:Electron) : Electron {
//        you.setElectron(this)
//        this.setSpin(Spin.Static.MINUS)
//        return this
//    }
}