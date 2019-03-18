


Public class Cards extends Window {

    TextArea description;

    public Cards() {
        HorizontalLayout horizontalLayout_init = new HorizontalLayout();
        horizontalLayout_init.setMargin(true);
        horizontalLayout_init.setSizeFull();
        HorizontalLayout layout_1 = new HorizontalLayout();
        horizontalLayout_init.addComponent(layout_1);

        //layout for grid
        VerticalLayout layout_2 = new VerticalLayout();
        layout_1.addComponent(layout_2);

        //label text
        Label insertName = new Label("Description");
        insertName.setVisible(true);
        layout_2.addComponent(insertName);








    }












}