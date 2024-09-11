import java.util.ArrayList;
import java.util.Scanner;

public class Competition {
    public void run() {
        ArrayList<Participant> participants = addParticipants();
        highestScore(participants);
        averageScore(participants);

    }

    /**
     * Ask user to add participants and their score.
     *
     * @return - A map where key is participant's name and value is score.
     */
    private ArrayList<Participant> addParticipants() {
        ArrayList<Participant> participants = new ArrayList<>();
        String name;
        int score;

        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Type 'done' or '-1' to finish adding participants.");
            System.out.println("Enter participant's full name: ");
            name = input.nextLine();
            if (name.equals("done") || name.isEmpty()) break;
            System.out.println("Enter participant's score: ");
            score = input.nextInt();
            input.nextLine();
            if (score == -1) break;

            participants.add(new Participant(name, score));
        }

        return participants;
    }

    /**
     * Finds participants with the highest score.
     *
     * @param participants - Map of participants.
     */
    private void highestScore(ArrayList<Participant> participants) {
        ArrayList<Participant> highestScores = new ArrayList<>();
        int highestScore = 0;

        for (Participant participant: participants) {
            if (participant.score > highestScore) {
                highestScores.clear();
                highestScore = participant.score;
                highestScores.add(participant);
            } else if (participant.score == highestScore) {
                highestScores.add(participant);
            }
        }

        int iterator = 1;
        System.out.println("Participants with the highest scores: ");

        for (Participant participant: highestScores) {
            System.out.println(iterator + ". " + participant.name + ": " + participant.score);
            iterator++;
        }
    }

    /**
     * Calculates the highest score.
     *
     * @param participants - Map of participants.
     */
    private void averageScore(ArrayList<Participant> participants) {
        double sum = 0.0;

        for (Participant participant: participants) {
            sum += participant.score;
        }
        System.out.println("Average score: " + String.format("%.2f", sum / participants.size()));
    }
}
