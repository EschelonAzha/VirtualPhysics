package symmetrical.cosmic._physics.atomic.substance.molecules

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.bonds.covalent.Covalent
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class Molecule(private val entanglement:QuantumEntanglement= QuantumEntanglement()) : Molecular(), IQuantumEntanglement by entanglement, Covalent {

    object Static {
        const val LAST      : Int = -1
    }
    constructor() : this(QuantumEntanglement()) {
    }

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
        val (molecularId, remainder) = Strings.remainder(2, super.emit().radiate())
        return getLocalClassId()+remainder
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Molecule::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}