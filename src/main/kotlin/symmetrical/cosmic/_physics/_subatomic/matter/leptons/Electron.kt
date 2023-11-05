package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals

class Electron : Lepton {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    lateinit var orbitals : Orbitals


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


}