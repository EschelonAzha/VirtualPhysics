package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class CRLFTerminatedMomentum(
    private val entanglement: IQuantumEntanglement
) : AngularMomentum(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(CRLFTerminatedMomentum::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun format(wavelength: Wavelength) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
}