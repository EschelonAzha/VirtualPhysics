package symmetrical.cosmic._physics._creation


import asymmetrical.machine.threads.Cores
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class BigBang (
    private val luminescent: ILuminescent = Luminescent(BigBang::class),
):
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(BigBang::class),
    )

    private lateinit var universe       : Universe
    var cores                           : Cores = Cores()

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i(universe: Universe) : BigBang {
        this.universe = universe;
        //  BootConfig.UNIVERSE = universe
        return this;
    }
    fun runUI() : Unit {
        // this starts and runs the browser UI
     //   Application.launch(FxLauncher::class.java)
    }

    fun run() : Unit {
        // this runs a console app
        this.universe.run()
    }

}