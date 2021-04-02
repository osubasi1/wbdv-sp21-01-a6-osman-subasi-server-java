package com.example.wbdvsp2103osubasiserverjava.services;

import com.example.wbdvsp2103osubasiserverjava.models.Widget;
import com.example.wbdvsp2103osubasiserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;
  private List<Widget> widgets = new ArrayList<Widget>();

  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    return repository.save(widget);

  }

  public List<Widget> findAllWidgets() {
    return repository.findAllWidget();

  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
  }

  public Widget findWidgetById(Long id) {
    return repository.findWidgetById(id);

  }

  public Integer updateWidget(Long id, Widget newWidget) {
    Widget original = repository.findWidgetById(id);
    original.setText(newWidget.getText());
    original.setType(newWidget.getType());
    original.setHeight(newWidget.getHeight());
    original.setWidth(newWidget.getWidth());
    original.setSize(newWidget.getSize());
    repository.save(original);
    return 1;
  }

  public Integer deleteWidget(Long widgetId) {
    repository.deleteById(widgetId);
    return 1;
  }
}
