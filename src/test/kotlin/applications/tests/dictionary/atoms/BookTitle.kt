package applications.tests.dictionary.atoms

import symmetrical.dictionary.protons.AccessLevelProton
import symmetrical.dictionary.protons.FieldNameProton
import symmetrical.dictionary.protons.quarks.formats.DoubleQuotedFormat
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter


class BookTitle (
    private val matterAntiMatter: IMatter = Matter().with(BookTitle::class),
) : Hydrogen(),
    IMatter by matterAntiMatter
{
    init {
        setFormatQuark(DoubleQuotedFormat())
    }
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        val classId = matterAntiMatter.getClassId()
        return Photon().with(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
}