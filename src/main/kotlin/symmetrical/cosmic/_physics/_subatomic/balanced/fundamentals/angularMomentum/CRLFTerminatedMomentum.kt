package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.luminescent.*

class CRLFTerminatedMomentum(
    private val matter: IMatter = Matter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class),
) : AngularMomentum(),
    IMatter by matter
{
    constructor() : this(
        Matter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class),
    )

    override fun format(wavelength: QuantumField) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

}