package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Electron(
    private val entanglement:IQuantumEntanglement
) : Lepton(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )

    lateinit var orbitals : Orbitals

    private lateinit var proton         : Proton
    private          var particleBeam   : ParticleBeam = ParticleBeam()



    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
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

    fun flow() : ParticleBeam {
        val result : ParticleBeam = ParticleBeam()
        for (i:Int in 0 until particleBeam.size()) {
            val electron = particleBeam.get(i) as Electron
            result.add(flow(electron))
        }

        return result
    }
    private fun flow(electron:Electron) : ZBoson {
        val terminal: Proton? = electron!!.proton

        if (terminal == null)
            return ZBoson().i(proton.getField())
        if (electron.fundamentals.getSpin().isPlus())
            return  terminal.interact(ZBoson().i(proton.getField()))
        else return terminal.capacitanceChange(ZBoson().i(proton.getField()).setOldValue(terminal.getValue()))

    }


    fun setProton(proton: Proton) : Electron {
        this.proton = proton
        return this
    }
    fun setSpin(spin:Int) : Electron {
        fundamentals.getSpin().setSpin(spin)
        return this
    }
    private fun setElectron(electron:Electron) : Electron {
        val particle: IParticle = electron as IParticle
        val pos = particleBeam.find(electron as IParticle)
        if (pos == -1)
            particleBeam.add(electron)

        return this
    }
    fun covalentBond(you:Electron) : Electron {
        you.setElectron(this)
        this.setSpin(Spin.Static.PLUS)
        return this
    }
    fun ionicBond(you:Electron) : Electron {
        you.setElectron(this)
        this.setSpin(Spin.Static.MINUS)
        return this
    }

}