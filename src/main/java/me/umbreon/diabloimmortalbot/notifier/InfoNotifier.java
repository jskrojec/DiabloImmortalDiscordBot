package me.umbreon.diabloimmortalbot.notifier;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class InfoNotifier {

    public void runScheduler(final JDA jda) {
        final Date nextFullMinuteTime = getNextFullMinuteTime();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jda.getPresence().setActivity(Activity.playing("Diablo Immortal | " + jda.getGuilds().size()));
            }
        }, nextFullMinuteTime, 60 * 1000);
    }


    @NotNull
    private Date getNextFullMinuteTime() {
        final Date date = Calendar.getInstance().getTime();
        date.setMinutes(date.getMinutes() + 1);
        date.setSeconds(0);
        return date;
    }
}
