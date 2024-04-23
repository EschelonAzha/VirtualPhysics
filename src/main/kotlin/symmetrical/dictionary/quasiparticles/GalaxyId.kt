package symmetrical.dictionary.quasiparticles


import asymmetrical.physics.machine.config.Config
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.transpectors.printable_characters.Base52

class GalaxyId (
    private val matterAntiMatter: IMatter = Matter().with(GalaxyId::class)
) : QuasiParticle(),
    IMatterAntiMatter by matterAntiMatter
{

    fun with(content:String) : GalaxyId {
        setContent(content)
        return this
    }

    fun getRemoteId() : RemoteId {
        val id = Base52.toFixedBase52(Config.getGalaxyIdLth(), toInt() + Base52.Static.MAX_SESSIONS)
        return RemoteId().with(id) as RemoteId
    }
    fun setGalaxyId(galaxyId:GalaxyId) : GalaxyId {
        setContent(galaxyId.toString())
        return this
    }
    override fun toInt() : Int {
        val id = toString()
        return Base52.toInt(id)
    }





    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}