package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.InterruptibleChannel;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.Receiver;

public class FacebookFriendCluster {
	public static void main(String[] args) throws IOException {

		HashMap<String, HashMap<String, Integer>> cluster = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, HashMap<String, Integer>> interaction = new HashMap<String, HashMap<String, Integer>>();

		File file = new File("C:\\Users\\Abhishek\\Desktop\\micro\\input.txt");
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String[] userlist = line.split("\t");
				if (userlist.length > 0) {
					// Process line of input Here
					String sender = userlist[1];
					String reciever = userlist[2];
					if (!interaction.containsKey(sender)) {
						HashMap thisInteraction = new HashMap<String, Integer>();
						thisInteraction.put(reciever, 0);
						interaction.put(sender, thisInteraction);
					} else {
						HashMap interactionList = interaction.get(sender);
						if (!interactionList.containsKey(reciever)) {
							interaction.remove(sender);
							interactionList.put(reciever, 0);
							interaction.put(sender, interactionList);
						}
					}
				}
			}
			System.out.println(interaction);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
