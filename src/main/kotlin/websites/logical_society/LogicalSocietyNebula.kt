package websites.logical_society

import asymmetrical.machine.vm.remote_terminal.RemoteTerminal

class LogicalSocietyNebula : RemoteTerminal {

    constructor() {
    }

    override fun onOpen() : Unit {
        app = LogicalSocietyApp().setNebula(this).setGalaxy(getGalaxy() as LogicalSocietyGalaxy)
    }
    override fun onClose() : Unit {
        return
    }

}