package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class CRLFTerminatedMomentum(
    private val antiMatter: IAntiMatter = AntiMatter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class),
) : AngularMomentum(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(CRLFTerminatedMomentum::class, CRLFTerminatedMomentum::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun format(wavelength: Wavelength) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
}