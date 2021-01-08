package xyz.pixelatedw.MineMineNoMi3.lists;

import java.util.HashMap;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.quests.bounties.lowlevel.BountyLowLevel01;
import xyz.pixelatedw.MineMineNoMi3.quests.bounties.lowlevel.BountyLowLevel02;
import xyz.pixelatedw.MineMineNoMi3.quests.bounties.lowlevel.BountyLowLevel03;
import xyz.pixelatedw.MineMineNoMi3.quests.poneglyphs.QuestPoneglyphChallengeCrocodile;
import xyz.pixelatedw.MineMineNoMi3.quests.questlines.sniperprogression.QuestSniperProgression01;
import xyz.pixelatedw.MineMineNoMi3.quests.questlines.sniperprogression.QuestSniperProgression02;
import xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression.QuestSwordsmanProgression01;
import xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression.QuestSwordsmanProgression02;
import xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression.QuestSwordsmanProgression03;
import xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression.QuestSwordsmanProgression04;
import xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression.QuestSwordsmanProgression05;

public class ListQuests {
  public static HashMap<String, Quest> allQuests = new HashMap<>();
  
  public static Quest swordsmanProgression01 = (Quest)new QuestSwordsmanProgression01();
  
  public static Quest swordsmanProgression02 = (Quest)new QuestSwordsmanProgression02();
  
  public static Quest swordsmanProgression03 = (Quest)new QuestSwordsmanProgression03();
  
  public static Quest swordsmanProgression04 = (Quest)new QuestSwordsmanProgression04();
  
  public static Quest swordsmanProgression05 = (Quest)new QuestSwordsmanProgression05();
  
  public static Quest sniperProgression01 = (Quest)new QuestSniperProgression01();
  
  public static Quest sniperProgression02 = (Quest)new QuestSniperProgression02();
  
  public static Quest bountyLowLevel01 = (Quest)new BountyLowLevel01();
  
  public static Quest bountyLowLevel02 = (Quest)new BountyLowLevel02();
  
  public static Quest bountyLowLevel03 = (Quest)new BountyLowLevel03();
  
  public static Quest poneglyphChallengeCrocodile = (Quest)new QuestPoneglyphChallengeCrocodile();
  
  public static void init() {
    registerQuest(swordsmanProgression01);
    registerQuest(swordsmanProgression02);
    registerQuest(swordsmanProgression03);
    registerQuest(swordsmanProgression04);
    registerQuest(swordsmanProgression05);
    registerQuest(sniperProgression01);
    registerQuest(sniperProgression02);
    registerQuest(bountyLowLevel01);
    registerQuest(bountyLowLevel02);
    registerQuest(bountyLowLevel03);
    registerQuest(poneglyphChallengeCrocodile);
  }
  
  private static void registerQuest(Quest quest) {
    WyRegistry.registerName("quest." + quest.getQuestID() + ".name", quest.getQuestName());
    for (int i = 0; i < (quest.getQuestDescription()).length; i++) {
      if (!quest.getQuestDescription()[i].isEmpty())
        WyRegistry.registerName("quest." + quest.getQuestID() + ".desc." + i, quest.getQuestDescription()[i]); 
    } 
    allQuests.put(quest.getQuestID(), quest);
  }
}
