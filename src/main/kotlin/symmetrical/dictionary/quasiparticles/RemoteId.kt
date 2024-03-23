package symmetrical.dictionary.quasiparticles

import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.luminescent.QuasiParticle

class RemoteId (
    private val matterAntiMatter: IMatter = Matter().with(RemoteId::class)
) : QuasiParticle(),
    IMatterAntiMatter by matterAntiMatter
{

    fun with(content:String) : RemoteId {
        setContent(content)
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun setRemoteId(remoteId:RemoteId) : RemoteId {
        setContent(remoteId.toString())
        return this
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
}