package symmetrical.cosmic.dictionary.formats

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.*

class CRLFTerminatedMomentum(
    private val matter: IMatter = Matter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class),
) : AngularMomentum(),
    IMatter by matter
{
    constructor() : this(
        Matter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class),
    )

    override fun run(wavelength: Field) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

}