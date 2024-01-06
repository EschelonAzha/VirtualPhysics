package symmetrical.cosmic.physics.subatomic.spacial

import symmetrical.cosmic.physics.subatomic.balanced.IParticle
import symmetrical.cosmic.physics.subatomic.bosons.Photon

/*
https://en.wikipedia.org/wiki/Particle_beam
 */
interface IParticleBeam : IBeam {
                        fun add                 (particle: IParticle)           : IParticle
                        fun emit                ()                              : Photon
    override operator   fun get                 (pos:Int)                       : IParticle
        override        fun getClassId          ()                              : String
                        fun getParticleCore     ()                              : Array<IParticle>
                        fun set                 (pos:Int, particle: IParticle)  : IParticle
}