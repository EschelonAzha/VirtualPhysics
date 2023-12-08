package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.luminescent.*

class CRLFTerminatedMomentum(
    private val matter: IMatter = Matter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class, true),
) : AngularMomentum(),
    IMatter by matter
{
    constructor() : this(
        Matter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class, true),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun format(wavelength: QuantumPhotonicField) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
}