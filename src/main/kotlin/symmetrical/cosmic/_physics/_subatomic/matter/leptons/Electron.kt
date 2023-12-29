package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Electron(
    private val matter: IMatter = Matter(Electron::class, Positron::class),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(Electron::class, Positron::class),
    )
    init {
    }
            lateinit var orbitals       : Orbitals
    private          var particleBeam   : ParticleBeam = ParticleBeam()
    private lateinit var proton         : Proton

    fun i(orbitals:Orbitals) : Electron {
        super.i()
        this.orbitals = orbitals
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    fun covalentBond(you:Electron) : Electron {
        you.setElectron(this)
        this.setSpin(Spin.Static.PLUS)
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
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    fun ionicBond(you:Electron) : Electron {
        you.setElectron(this)
        this.setSpin(Spin.Static.MINUS)
        return this
    }

    fun setOrbitals(orbitals: Orbitals) : Electron {
        this.orbitals = orbitals
        return this
    }

    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
    fun setProton(proton: Proton) : Electron {
        this.proton = proton
        return this
    }
    fun setSpin(spin:Int) : Electron {
        getSpin().setSpin(spin)
        return this
    }
    private fun flow(electron:Electron) : ZBoson {
        val terminal: Proton? = electron!!.proton

        if (terminal == null)
            return ZBoson().i(proton.getField())
        if (electron.getSpin().isPlus())
            return  terminal.interact(ZBoson().i(proton.getField()))
        else return terminal.capacitanceChange(ZBoson().i(proton.getField()).setOldValue(terminal.getContent()))

    }
    private fun setElectron(electron:Electron) : Electron {
        val particle: IParticle = electron as IParticle
        val pos = particleBeam.find(electron as IParticle)
        if (pos == -1)
            particleBeam.add(electron)

        return this
    }
}