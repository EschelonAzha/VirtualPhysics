package symmetrical.dictionary.atoms

import symmetrical.dictionary.protons.quarks.formats.CRLFTerminatedFormat
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.atomic.atoms.states.strings.QString
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter

class CRLFTerminatedString(
    private val matterAntiMatter: IMatter = Matter().with(CRLFTerminatedString::class),
) : Hydrogen() ,
    IMatter by matterAntiMatter
{
    init {
        setFormat(CRLFTerminatedFormat())
    }
    override fun with(value:Any?) : CRLFTerminatedString {
        super.with(value)
        return this
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

}